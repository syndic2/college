#include <Keypad.h>
#include <DS3232RTC.h>
#include "LCD.h"
#include "LiquidCrystal_I2C.h"

LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE); 

const byte ROWS = 4; 
const byte COLS = 4;
char keys[ROWS][COLS] = {
  {'1','2','3','='},
  {'4','5','6','C'},
  {'7','8','9','-'},
  {'*','0','#','+'}
};
byte rowPins[ROWS] = {2, 3, 4, 5}; 
byte colPins[COLS] = {6, 7, 8, 9}; 

Keypad kpd = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS);

void setup() {
  lcd.begin(16,2);
  setSyncProvider(RTC.get);  // Library function to get the time from the RTC module.

  lcd.setCursor(0,0);  lcd.print("  JAM  DIGITAL  "); 
  lcd.setCursor(0,1);  lcd.print("    MURAHAN     ");
  
  delay(2000);

  lcd.clear();
}

int modeGanti= 0;

int modeWaktu= 0;
int ctrJam= 0,
    ctrMenit= 0,
    ctrDetik= 0;

int modeTanggal= 0;
int ctrHari= 0,
    ctrBulan= 0,
    ctrTahun= 0;

String jam= "hh", 
       menit= "Mn Mn", 
       detik= "SS",
       waktu= "DAY";

String hari= "dd", 
       bulan= "mm", 
       tahun= "yyyy",
       bln= "BLN";

String input1= "",
       input2= "",
       input3= "",
       input4= "";

void loop() {
  char key = kpd.getKey(); 
  
  if (modeWaktu == 4) { 
    setRTCWaktu();
    modeGanti= 0;
  }
  
  if (modeTanggal == 4) { 
    setRTCTanggal();
  }
     
  if (key == '*') { //BUAT WAKTU
    lcd.clear();
    modeGanti= 1;
     
    if (modeGanti == 1) {
      modeWaktu++;
    }
  } else if (key == '#') { //BUAT TANGGAL
     lcd.clear();
     modeGanti= 2;
     
     if (modeGanti == 2) {
      modeTanggal++;
    }
  } else if (key == '1' || key == '2' || key == '3' ||
             key == '4' || key == '5' || key == '6' ||
             key == '7' || key == '8' || key == '9'){ //TEKAN ANGKA
    if (modeGanti == 1) {
      aturWaktu(key);
    } else if (modeGanti == 2) {
      aturBulan(key);
    }
  }
  
  //RENDER
  if (modeGanti == 0) { //TIMER JALAN
    //setRTCAwal();
    //lcd.setCursor(0, 0); lcd.print(String(hour())+":"+String(minute())+":"+String(second())+"     GNT");
    //lcd.setCursor(0, 1); lcd.print(String(day())+"/"+String(month())+"/"+String(month()));
    lcd.setCursor(0, 0); lcd.print(jam+":"+menit+":"+detik+"     GNT");
    lcd.setCursor(0, 1); lcd.print(hari+"/"+bulan+"/"+tahun);
  } else if (modeGanti == 1) {
    lcd.setCursor(0, 0); lcd.print(jam+":"+menit+":"+detik+"     GNT");
    lcd.setCursor(0, 1); lcd.print(hari+"/"+bulan+"/"+tahun);
  } else if (modeGanti == 2) {
    lcd.setCursor(0, 0); lcd.print(jam+":"+menit+":"+detik);
    lcd.setCursor(0, 1); lcd.print(hari+"/"+bulan+"/"+tahun+"   GNT");    
  }
}

void aturWaktu(char key) {
  if (modeWaktu == 1) {
    if (ctrJam == 0) {
      input1= String(key);
      jam= "0"+input1;
      ctrJam++;
    } else if (ctrJam == 1){
      input2= String(key);
      jam= input1+input2;
      ctrJam= 0;
    }
  } else if (modeWaktu == 2) {
    if (ctrMenit == 0) {
      input1= String(key);
      menit= "0"+input1;
      ctrMenit++;
    } else if (ctrMenit == 1){
      input2= String(key);
      menit= input1+input2;
      ctrMenit= 0;
    } 
  } else if (modeWaktu == 3) {
    if (ctrDetik == 0) {
      input1= String(key);
      detik= "0"+input1;
      ctrDetik++;
    } else if (ctrDetik == 1){
      input2= String(key);
      detik= input1+input2;
      ctrDetik= 0;
    }
  } 
}

void setRTCAwal() {
  time_t t1;
  tmElements_t tm1;
  tm1.Hour= jam.toInt();
  tm1.Minute= menit.toInt();
  tm1.Second= detik.toInt();
  
  tm1.Year= CalendarYrToTm(tahun.toInt());
  tm1.Month= bulan.toInt();
  tm1.Day= hari.toInt();
  
  t1 = makeTime(tm1);
  
  RTC.set(t1);
  setTime(t1);
}

void setRTCWaktu() {
  time_t t;
  tmElements_t tm;
  tm.Hour= jam.toInt();
  tm.Minute= menit.toInt();
  tm.Second= detik.toInt();
  t = makeTime(tm);
  
  RTC.set(t);
  setTime(t);     
}

void setRTCTanggal() {
  time_t t;
  tmElements_t tm;
  tm.Year= CalendarYrToTm(tahun.toInt());
  tm.Month= bulan.toInt();
  tm.Day= hari.toInt();
  t = makeTime(tm);
  
  RTC.set(t);
  setTime(t);
}

void aturBulan(char key) {
  if (modeTanggal == 1) {
    if (ctrHari == 0) {
      input1= String(key);
      hari= "0"+input1;
      ctrHari++;
    } else if (ctrHari == 1){
      input2= String(key);
      hari= input1+input2;
      ctrHari= 0;
    }
  } else if (modeTanggal == 2) {
    if (ctrBulan == 0) {
      input1= String(key);
      bulan= "0"+input1;
      ctrBulan++;
    } else if (ctrBulan == 1){
      input2= String(key);
      bulan= input1+input2;
      ctrBulan= 0;
    } 
  } else if (modeTanggal == 3) {
    if (ctrTahun == 0) {
      input1= String(key);
      tahun= "yyy"+input1;
      ctrTahun++;
    } else if (ctrTahun == 1){
      input2= String(key);
      tahun= "yy"+input1+input2;
      ctrTahun++;
    } else if (ctrTahun == 2) {
      input3= String(key);
      tahun= "y"+input1+input2+input3;
      ctrTahun++;
    } else if (ctrTahun == 3) {
      input4= String(key);
      tahun= input1+input2+input3+input4;
      ctrTahun= 0;
    }
  } 
}
