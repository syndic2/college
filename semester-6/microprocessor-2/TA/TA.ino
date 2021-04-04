#include <Keypad.h>
#include <Wire.h>
#include "LiquidCrystal_I2C.h"  // F Malpartida's NewLiquidCrystal library

LiquidCrystal_I2C lcd(0x27, 5, 4);  // set the LCD address to 0x27 for a 16 chars and 2 line display

const byte ROWS = 4; 
const byte COLS = 3;
char keys[ROWS][COLS] = {
  {'1','2','3'},
  {'4','5','6'},
  {'7','8','9'},
  {'*','0','#'}
};

byte rowPins[ROWS] = {2, 3, 4, 5}; 
byte colPins[COLS] = {6, 7, 8 }; 

Keypad kpd = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

int a= 0,
    b= 0;

int modeIsiKar= 1;
int kodeKar= 0;

String atas= "Kamu SiapA",
       bawah= "a.Bos  b.Kar";

String inputNo= "";
String dbNomor[5];

void setup() {
  lcd.begin(24, 2);
  lcd.setCursor(0, 0); lcd.print(atas); 
  lcd.setCursor(0, 1); lcd.print(bawah); 
  
  pinMode(12, INPUT); //bos
  pinMode(13, INPUT); //karyawan
}

void loop() {
  char key = kpd.getKey();
    
  if (digitalRead(13) == 1 && a == 0) a= 1;
  else if (digitalRead(13) == 0 && a == 1) {
    a= 0;
    atas= "No Karyawan";
    bawah= "";

    if (modeIsiKar == 0) { modeIsiKar= 1; }
    else if (modeIsiKar == 1) {
      int karMasuk= 0;
      bool cekMasuk= false;
      
      if (kodeKar > 0) { //cek sudah ada karyawan
       for (int i= 0; i<kodeKar; i++) {
          if (dbNomor[i] == inputNo) {
            karMasuk= i;
            cekMasuk= true;
          } else {
            atas= "Coba lagi";
          }
        }
      } else { //kalau belum ada tambahkan dulu
        dbNomor[kodeKar]= inputNo;
        kodeKar++;
      }
      
      if (cekMasuk) {
        atas= "Karyawan"+String(kodeKar)+" Masuk";
        bawah= ""; 
      }
      
      modeIsiKar= 0; 
    }
    
    lcd.clear();
  }

  if (key == '0' || key == '1' || key == '2' ||
      key == '3' || key == '4' || key == '5' ||
      key == '6' || key == '7' || key == '8' ||
      key == '9') {
    if (modeIsiKar == 1) {  
      if (inputNo.length() < 5) {
        inputNo+= String(key);
        bawah= inputNo;
        
        lcd.clear();
      }
    }
  }
  
  if (modeIsiKar == 0) { //TAMPILAN AWAL
    lcd.setCursor(0, 0); lcd.print(atas); 
    lcd.setCursor(0, 1); lcd.print(bawah); 
  }
}
