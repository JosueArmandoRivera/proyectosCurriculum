#include <ESP32Servo.h>
#include <analogWrite.h>

#include <WiFi.h>
#include <WiFiAP.h>
#include <WiFiClient.h>
#include <WiFiGeneric.h>
#include <WiFiMulti.h>
#include <WiFiScan.h>
#include <WiFiServer.h>
#include <WiFiSTA.h>
#include <WiFiType.h>
#include <WiFiUdp.h>


int pin = 26;
int ang = 180;
int ang2 = 0;
const char* ssid = "Megcable_2.4G_AFBA";
const char* password = "xPApGFFm";
WiFiServer server(80);
Servo motor; 

void setup() {
  Serial.begin(115200);
  motor.attach(pin);
  motor.write(ang);
  Serial.print("Conectando");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.print("");
  Serial.print("WIFI CONECTED");
  Serial.print("IP ADDRESS");
  Serial.print(WiFi.localIP());
  server.begin();
}

void loop() {
  WiFiClient client = server.available();
  if (client) {
    Serial.print("Nuevo cliente");
    while (!client.available() && client.connected()) {
      delay(1);
    }
    String lineal = client.readStringUntil('r');
    Serial.print(lineal);
    if (lineal.indexOf("LED=OPEN") > 0) {
      motor.write(ang);
      Serial.println("hola");
    }
    if (lineal.indexOf("LED=CLOSE") > 0) {
      motor.write(ang2);
    }
    Serial.println("Enviando respuesta..");
    client.println("HTTP/1.1 200 OK");
    client.println("Content-Type: text/html");
    client.println("Connection: close");
    client.println();
    client.println("<!DOCTYPE HTML>");
    client.println("<html>");
    client.println("<head><title>Servo esp32</title></head>");
    client.println("<body>");
    client.println("<h1 align='center'>Controla un servo motor con esp32</h1>");
    client.println("<div style='text-align:center;'>");
    client.println("<br />");
    client.println("<button  onClick=location.href='./?LED=OPEN' style='background:#92d050;color:white;border:none; font-size:15px;>ABRIR</button>");
    client.println("<button onClick=location.href='./?LED=CLOSE'>CERRAR</button>");
    client.println("<br />");
    client.println("</div >");
    client.println("</body>");
    client.println("</html>");
    delay(1);
    Serial.println("Respuesta Enviada");
    Serial.println();
  }

}
