#include <Keypad.h>
#include "LCD.h"
#include "LiquidCrystal_I2C.h"

LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE); 

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

int arrPin2[8] = { LOW, LOW, LOW, LOW, HIGH,HIGH,HIGH, HIGH }; 
int arrPin1[8] = { LOW, LOW, HIGH,HIGH,LOW, LOW, HIGH, HIGH }; 
int arrPin0[8] = { LOW, HIGH,LOW, HIGH,LOW, HIGH,LOW,  HIGH }; 

//pin0= 10, pin1= 11, pin2= 12, pinFlag= 13

void setup() {
  pinMode(12, OUTPUT); 
  pinMode(11, OUTPUT);
  pinMode(10, OUTPUT);  
  pinMode(13, OUTPUT);  
  
  lcd.begin(16, 2);
}

String num1= "35",
       num2= "00";
int ctrNum= 0,
    hitung= 0;

int mode= 0;

void loop() {
  char key = kpd.getKey();
  
  if (key == '0' || key == '1' || key == '2' || key == '3' ||
      key == '4' || key == '5' || key == '6' || key == '7' || 
      key == '8' || key == '9') {
    hitung+= String(key).toInt();

    if (hitung >= 0 && hitung < 10) {
      num2= "0"+String(hitung);
    } else {
      num2= hitung;
    }

    ctrNum+= 1;
    
    //8 kali
    if (ctrNum == 8) {
      if (hitung == 35) {   
        mode= 1;
        hitung= 0;
        
        lcd.clear();
      } else {
        num2= "00";
        mode= 0;
        hitung= 0;
        ctrNum= 0;
        
        lcd.clear();
      }
    }
  }
  
  if (mode == 0) { 
    lcd.setCursor(0, 0); lcd.print(num1+"/"+num2);
  } else if (mode == 1) {
    lcd.setCursor(0, 0); lcd.print("ppps/apas");
    lcd.setCursor(0, 1); lcd.print("selamat  datang");
  }
}
