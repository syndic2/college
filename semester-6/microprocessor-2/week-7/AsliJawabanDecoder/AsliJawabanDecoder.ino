#include <Keypad.h>
#include <DS3232RTC.h>
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

// kiri ke kanan    0    1    2    3    4    5    6     7
int isiPin2[8] = { LOW, LOW, LOW, LOW, HIGH,HIGH,HIGH, HIGH }; 
int isiPin1[8] = { LOW, LOW, HIGH,HIGH,LOW, LOW, HIGH, HIGH }; 
int isiPin0[8] = { LOW, HIGH,LOW, HIGH,LOW, HIGH,LOW,  HIGH }; 

int pin2 = 12;      // PIN C
int pin1 = 11;      // PIN B
int pin0 = 10;      // PIN A
int pinFlag = 13;   // PIN Flag On/Off
int mode = 0;       // mode tampilan layar 
                    // 0=judul 1=input angka 2=input delay 3=start 4 = stop
String minput = ""; 
String mdelay = ""; 

void setup() {
  pinMode(pin2, OUTPUT); 
  pinMode(pin1, OUTPUT);
  pinMode(pin0, OUTPUT);  
  pinMode(pinFlag, OUTPUT);  
  
  lcd.begin(16,4);  
  mode = 0; 
}

void loop() {
  if(mode == 0) {   
    lcd.setCursor(0, 0);  lcd.print("LED CONTROLLER"); 
    lcd.setCursor(0, 1);  lcd.print("Nrp Kalian"); 
    lcd.setCursor(0, 2);  lcd.print("Minggu 7"); 
    delay(2000); 
    mode = 1; 
    lcd.clear(); 
  }
  else if(mode == 1 || mode == 2) {
    lcd.setCursor(0, 0);  lcd.print("Input   = " + String(minput)); 
    lcd.setCursor(0, 1);  lcd.print("Delay   = " + String(mdelay)); 
    lcd.setCursor(0, 2);  lcd.print("1. Start  3. Clear");     
    lcd.setCursor(0, 3);  lcd.print("2. Stop");     
  }
  else if(mode == 3) {
    int angka = minput.toInt(); 
    int waktu = mdelay.toInt(); 
    
    int nomer = 0; 
    while(ceil(pow(2,nomer)) < angka)
    {
      nomer+=1; 
    }

    // hidup
    digitalWrite(pin2, isiPin2[nomer]); 
    digitalWrite(pin1, isiPin1[nomer]); 
    digitalWrite(pin0, isiPin0[nomer]); 
    digitalWrite(pinFlag, HIGH);
    delay(waktu); 
    // mati
    digitalWrite(pinFlag, LOW);
    delay(waktu); 
  }
  else if(mode == 4) {
    digitalWrite(pinFlag, LOW);
  }

  char key = kpd.getKey();
  if(key != NO_KEY)    // artinya ada yg ditekan dalam keypad itu
  {
      if(mode == 1 ||mode == 2 || mode == 3 || mode == 4) {
        if(key == '*')
        {        
          mode+=1; 
          if(mode == 5) { mode = 4; }
        }
        else if(key == '#') {
          lcd.clear(); 
          minput = ""; 
          mdelay = ""; 
          digitalWrite(pinFlag, LOW);
          mode = 1; 
        }
        else if(key == '0' || key == '1' || key == '2' || key == '3' || key == '4' || 
        key == '5' || key == '6' || key == '7' || key == '8' || key == '9') 
        {
          if(mode == 1) {
            minput = minput + key; 
          }
          else if(mode == 2) {
            mdelay = mdelay + key; 
          }
        }
      }
  }
  delay(1); 
}
