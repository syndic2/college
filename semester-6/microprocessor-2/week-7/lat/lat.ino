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

int modeGanti= 0;
int start= 0;

void setup() {
  pinMode(12, OUTPUT); 
  pinMode(11, OUTPUT);
  pinMode(10, OUTPUT);  
  pinMode(13, OUTPUT);  
  
  lcd.begin(16, 4);

  lcd.setCursor(0, 0); lcd.print("  LED CONTROLLER");
  lcd.setCursor(0, 1); lcd.print("    217116615");
  lcd.setCursor(0, 2); lcd.print("     MINGGU 7");

  delay(2000);

  lcd.clear();
}

String input= "",
       waktu= "";

int idx= 0;

void loop() {
  char key = kpd.getKey();
  
  if (key == '0' || key == '1' || key == '2' || key == '3' ||
      key == '4' || key == '5' || key == '6' || key == '7' || 
      key == '8' || key == '9') {
    if (modeGanti == 0) { //ISI INPUT
      input= input + String(key);
    } else if (modeGanti == 1) { //ISI DELAY
      waktu= waktu + String(key);
    }
  } else if (key == '*' || key == '#') {
    if (key == '*') {
      modeGanti+= 1;
      
      if (modeGanti >= 2) { //JALANKAN LCD
        while(ceil(pow(2, idx)) < input.toInt()) {
          idx+= 1; 
        }

        if (start == 0) start= 1;
        else if (start == 1) start= 0; 
      }
    } else if (key == '#') { //RESET
      input= "";
      waktu= "";
      modeGanti= 0; 
      start= 0;

      lcd.clear();
    }
  }

  //1= START, 0= STOP
  if (start == 1) {
    // hidup
    digitalWrite(12, arrPin2[idx]); 
    digitalWrite(11, arrPin1[idx]); 
    digitalWrite(10, arrPin0[idx]); 
    digitalWrite(13, HIGH);
    delay(waktu.toInt());
     
    // mati
    digitalWrite(13, LOW);
    delay(waktu.toInt());
  } else if (start == 0) {
    digitalWrite(13, LOW);
  }
  
  lcd.setCursor(0, 0); lcd.print("INPUT: "+input);
  lcd.setCursor(0, 1); lcd.print("DELAY: "+waktu);
  lcd.setCursor(0, 2); lcd.print("1.START  3.CLEAR");
  lcd.setCursor(0, 3); lcd.print("2.STOP");
}
