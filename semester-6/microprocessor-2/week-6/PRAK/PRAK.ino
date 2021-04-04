#include <Keypad.h>
#include <DS3232RTC.h>
#include "LCD.h"
#include "LiquidCrystal_I2C.h"

LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE); 

const byte ROWS = 4; 
const byte COLS = 4;
char keys[ROWS][COLS] = {
  {'7','8','9','#'},
  {'4','5','6','*'},
  {'1','2','3','-'},
  {'C','0','=','+'}
};
byte rowPins[ROWS] = {2, 3, 4, 5}; 
byte colPins[COLS] = {6, 7, 8, 9}; 

Keypad kpd = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

int mode = 0;       // mode tampilan layar 
                    // 0=judul 1=time 2=date
int modeganti = 0;  // 0=idle  1=jam  2=menit  3=detik                    
int jam = -1; 
int menit = -1; 
int detik = -1; 
int tanggal = -1; 
int bulan = -1; 
int tahun = -1; 

void setup() {
  lcd.begin(16,2);
  setSyncProvider(RTC.get);  // Library function to get the time from the RTC module.
/*
  time_t t;
  tmElements_t tm;
  tm.Year = CalendarYrToTm(2020);
  tm.Month    = 3;
  tm.Day      = 20;
  tm.Hour     = 15;
  tm.Minute   = 40;
  tm.Second   = 55;
  t = makeTime(tm);
  RTC.set(t);        // use the time_t value to ensure correct weekday is set
  setTime(t);
  if(timeStatus() != timeSet) {
    lcd.setCursor(0,0);
    lcd.print("Unable sync RTC");
  }
  else {
    lcd.setCursor(0,0);
    lcd.print("RTC set Time");
  }
*/
}

void loop() {
  if(mode == 0) {
    lcd.setCursor(0,0);   lcd.print("Digital Clock"); 
    lcd.setCursor(0,1);   lcd.print("NRP"); 
    delay(2000); 
    lcd.clear(); 
    mode = 1; 
  }
  else if(mode == 1) {
    if(modeganti == 0) {
      displayTime(); 
    }
    else {
      String kal = ""; 
      if(jam == -1)   { kal = kal + "hh" + ":"; }
      else {
        if(jam < 10) { kal = kal + "0" + String(jam) + ":"; }
        else { kal = kal + String(jam) + ":"; }
      }
      if(menit == -1) { kal = kal + "mm" + ":"; }
      else {
        if(menit < 10) { kal = kal + "0" + String(menit) + ":"; }
        else { kal = kal + String(menit) + ":"; }
      }
      if(detik == -1) { kal = kal + "ss";       }
      else {
        if(detik < 10) { kal = kal + "0" + String(detik); }
        else { kal = kal + String(detik); }
      }
      lcd.setCursor(0,0); lcd.print(kal); 
    }
  }
  else if(mode == 2) {
    if(modeganti == 0) {
      displayDate(); 
    }
    else {
      String kal = ""; 
      if(tanggal == -1)   { kal = kal + "dd" + "/"; }
      else {
        if(tanggal < 10) { kal = kal + "0" + String(tanggal) + ":"; }
        else { kal = kal + String(tanggal) + ":"; }
      }
      if(bulan == -1) { kal = kal + "mm" + "/"; }
      else {
        if(bulan < 10) { kal = kal + "0" + String(bulan) + ":"; }
        else { kal = kal + String(bulan) + ":"; }
      }
      if(tahun == -1) { kal = kal + "yyyy";       }
      else {
        if(tahun < 10) { kal = kal + "0" + String(tahun); }
        else { kal = kal + String(tahun); }
      }
      lcd.setCursor(0,0); lcd.print(kal); 
    }
  }
  
  char key = kpd.getKey();
  if(key != NO_KEY)    // artinya ada yg ditekan dalam keypad itu
  {
    if(mode == 1) {
      if(key == '#') { lcd.clear(); mode = 2; modeganti = 0; }
      if(key == '*') {
        modeganti+=1; 
        if(modeganti == 4) { 
          modeganti = 0; 
          time_t t;
          tmElements_t tm;
          tm.Hour     = jam;
          tm.Minute   = menit;
          tm.Second   = detik;
          t = makeTime(tm);
          RTC.set(t);        // use the time_t value to ensure correct weekday is set
          setTime(t);         
        }
      }

      if(key == '0' || key == '1' || key == '2' || key == '3' || key == '4' ||
         key == '5' || key == '6' || key == '7' || key == '8' || key == '9') {
        if(modeganti == 1) {    // aku menggantikan jam
          if(jam == -1 || jam >= 10) { jam = (String(key)).toInt(); }
          else { jam = (String(jam) + String(key)).toInt(); }
        }            
        else if(modeganti == 2) {// aku menggantikan menit
          if(menit == -1 || menit >= 10) { menit = (String(key)).toInt(); }
          else { menit = (String(menit) + String(key)).toInt(); }          
        }
        else if(modeganti == 3) {// aku menggantikan detik
          if(detik == -1 || detik >= 10) { detik = (String(key)).toInt(); }
          else { detik = (String(detik) + String(key)).toInt(); }  
        }
      }
    }
    else if(mode == 2) {
      if(key == '#') { lcd.clear(); mode = 1; modeganti = 0; }
      if(key == '*') {
        modeganti+=1; 
        if(modeganti == 4) { 
          modeganti = 0; 
          time_t t;
          tmElements_t tm;
          tm.Year = CalendarYrToTm(tahun);
          tm.Month    = bulan;
          tm.Day      = tanggal;
          t = makeTime(tm);
          RTC.set(t);        // use the time_t value to ensure correct weekday is set
          setTime(t);         
        }
      }

      if(key == '0' || key == '1' || key == '2' || key == '3' || key == '4' ||
         key == '5' || key == '6' || key == '7' || key == '8' || key == '9') {
        if(modeganti == 1) {    // aku menggantikan tanggal
          if(tanggal == -1 || tanggal >= 10) { tanggal = (String(key)).toInt(); }
          else { tanggal = (String(tanggal) + String(key)).toInt(); }
        }            
        else if(modeganti == 2) {// aku menggantikan bulan
          if(bulan == -1 || bulan >= 10) { bulan = (String(key)).toInt(); }
          else { bulan = (String(bulan) + String(key)).toInt(); }          
        }
        else if(modeganti == 3) {// aku menggantikan tahun
          if(tahun == -1 || tahun >= 1000) { tahun = (String(key)).toInt(); }
          else { tahun = (String(tahun) + String(key)).toInt(); }  
        }
      }
    }
  }
}

void displayTime()  // Function that prints the time to serial monitor.
{
    String waktu = ""; 
    if(hour() < 10) { waktu = waktu + "0" + String(hour()) + ":"; }
    else { waktu = waktu + String(hour()) + ":"; }
    if(minute() < 10) { waktu = waktu + "0" + String(minute()) + ":"; }
    else { waktu = waktu + String(minute()) + ":"; }
    if(second() < 10) { waktu = waktu + "0" + String(second()); }
    else { waktu = waktu + String(second()); }

    lcd.setCursor(0,0); 
    lcd.print(waktu); 

    String ketjam = "";
    if(jam >= 0 && jam <  10) { ketjam = "PAGI"; }
    if(jam >= 10&& jam <  15) { ketjam = "SIANG"; }
    if(jam >= 15&& jam <  18) { ketjam = "SORE"; }
    if(jam >= 18&& jam <= 24) { ketjam = "MALAM"; }
    
    lcd.setCursor(0,1); 
    lcd.print(ketjam); 
}

void displayDate()  // Function that prints the time to serial monitor.
{
    String waktu = ""; 
    if(day() < 10) { waktu = waktu + "0" + String(day()) + "/"; }
    else { waktu = waktu + String(day()) + "/"; }
    if(month() < 10) { waktu = waktu + "0" + String(month()) + "/"; }
    else { waktu = waktu + String(month()) + "/"; }
    waktu = waktu + String(year());

    String kethari = "";
    if(month() == 1) { kethari = "Januari"; }
    if(month() == 2) { kethari = "Februari"; }
    if(month() == 3) { kethari = "Maret"; }
    if(month() == 4) { kethari = "April"; }
    if(month() == 5) { kethari = "Mei"; }
    if(month() == 6) { kethari = "Juni"; }
    if(month() == 7) { kethari = "Juli"; }
    if(month() == 8) { kethari = "Agustus"; }
    if(month() == 9) { kethari = "September"; }
    if(month() == 10) { kethari = "Oktober"; }
    if(month() == 11) { kethari = "November"; }
    if(month() == 12) { kethari = "Desember"; }
    
    lcd.setCursor(0,1); 
    lcd.print(kethari); 
}
