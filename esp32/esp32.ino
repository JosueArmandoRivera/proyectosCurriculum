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



const char* ssid = "Megcable_2.4G_AFBA";
const char* password="xPApGFFm";
//const char* ssid = "Galaxy A323528";
//const char* password="21A00000";
WiFiServer server(80);

//pin1=8;
//pin2=7;
//pin3=6;
int r;
int b;
int g;

//int ledRojo =26;
//int ledVerde =14;
//int ledAzul =25;

int ledRojo =26;
int ledVerde =14;
int ledAzul =25;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  //delay(10);

  //Configuración del GPIO2
  pinMode(2,OUTPUT);
  digitalWrite(2,LOW);

  pinMode(ledRojo,OUTPUT);
  pinMode(ledVerde,OUTPUT);
  pinMode(ledAzul,OUTPUT);
  
  Serial.println("Conectado");
  Serial.println(ssid);
  WiFi.begin(ssid,password); 
  
  while(WiFi.status() != WL_CONNECTED){
    delay(500);
    Serial.print(".");
    } 
    Serial.print("");
    Serial.print("WIFI CONECTED");
    Serial.print("API ADDRESS");
    Serial.print(WiFi.localIP());
    
    server.begin();
}
void loop() {
  // put your main code here, to run repeatedly:
  WiFiClient client = server.available();
  if(client)//Si hay un cliente presente
  {
    Serial.println("Nuevo Cliente");
    //esperamos hasta que hayan datos disponibles
    while(!client.available()&&client.connected()){
      delay(1);
    }

    //Leemos la primera linea de la petición del cliente.
    String lineal = client.readStringUntil('r');
    Serial.println(lineal);
   
    if(lineal.indexOf("LED=ON")>0)//Buscamos un LED=ON en la 1°Linea
    {
      String paramstr=client.readStringUntil('\r');
      int p1= paramstr.indexOf("red=")+4;
      int p2= paramstr.indexOf("&",p1)+4;
      r=paramstr.substring(p1,p2).toInt();
      p1=paramstr.indexOf("green=")+6;
      p2=paramstr.indexOf("&",p1);
      g=paramstr.substring(p1,p2).toInt();
      p1=paramstr.indexOf("blue=")+5;
      p2=paramstr.indexOf(" ",p1);
      b=paramstr.substring(p1,p2).toInt();
      
      digitalWrite(ledRojo,r>0 ?HIGH :LOW);
      digitalWrite(ledAzul,b>0 ?HIGH :LOW);
      digitalWrite(ledVerde,g>0 ?HIGH :LOW);    
    
    }
    //if(lineal.indexOf("LED=OFF")>0)//Buscamos un LED=OF en la 1°Linea
   // {
     // digitalWrite(2,LOW);
      //}
      //client.flush();
      Serial.println("Enviando respuesta...");
      //Encabezado http

      
      Serial.println("Enviando respuesta");
      client.println("HTTP/1.1 200 OK");
      client.println("Content-Type:text/html");
      client.println("Connection: close");
      client.println();
      
      client.println("<!DOCTYPE HTML>");
      client.println("<html>");
      client.println("<head><title>UTL Electronics</title></head>");
      client.println("<body>");
      client.println("<center><h1>LED RGB</h1></center>");
      client.println("<div class='padre' style='display:flex; align-items:center; justify-content:center;'>");
      client.println("<div class='hijo'>");
      client.println("<input value='200'  placeholder='0 a 255'>");
      client.println("<input value='100'  placeholder='0 a 255'>");
      client.println("<input value='30'  placeholder='0 a 255'>");
      client.println("</div>");
      client.println("</div>");
      client.println("<div class='hijo2'>");
      client.println("<div class='etiquetas' id='input1'>RED</div>");
      client.println("<div class='etiquetas' id='input2'>Green</div>");
      client.println("<div class='etiquetas' id='input3'>Blue</div>");
      client.println("</div>");
      client.println("<div class='btn' style='display:flex;align-items:center;justify-content: center;'>");
      client.println("<Button id='btn' style='  margin-top: 30px;background: #92d050;color: white;border: none; font-size: 15px;padding:10px 20px 10px 20px;'>ENVIAR</button>");
      client.println("</div>");
      client.println("</body>");
      client.println("</html>");    

      client.println("<Form method='GET' action=!/LED=ON>");
      client.println("<input placeholder='Red'");
      client.println("<input placeholder='Green'");
      client.println("<input placeholder='Blue'"); 
      client.println("<input type='submit' placeholder='Blue'");       
      client.println("</Form>");
      
      delay(1);     
      Serial.println("respuesta enviada");
      Serial.println();      
  }
  }
