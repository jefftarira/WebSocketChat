package sockets;

import Models.DecodeMensaje;
import Models.EncoderMensaje;
import Models.Mensaje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat",
        encoders = {EncoderMensaje.class},
        decoders = {DecodeMensaje.class})
public class MiChat {

  private static final List<Session> conectados = new ArrayList<>();

  @OnOpen
  public void inicio(Session sesion) {
    conectados.add(sesion);
  }
  

  @OnClose
  public void salir(Session sesion) {
    conectados.remove(sesion);
  }

  @OnMessage
  public void mensaje(Mensaje mensaje) throws IOException, EncodeException {
    for (Session sesion : conectados) {
      sesion.getBasicRemote().sendObject(mensaje);
    }
  }

}
