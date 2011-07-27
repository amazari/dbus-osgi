package org.freedesktop;

import java.util.List;
import java.util.Map;

import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;

public interface Notifications extends DBusInterface
{
   public static class NotificationClosed extends DBusSignal
   {
      public final UInt32 a;
      public final UInt32 b;
      public NotificationClosed(String path, UInt32 a, UInt32 b) throws DBusException
      {
         super(path, a, b);
         this.a = a;
         this.b = b;
      }
   }
   public static class ActionInvoked extends DBusSignal
   {
      public final UInt32 a;
      public final String b;
      public ActionInvoked(String path, UInt32 a, String b) throws DBusException
      {
         super(path, a, b);
         this.a = a;
         this.b = b;
      }
   }

  public UInt32 Notify(String a, UInt32 b, String c, String d, String e, List<String> f, Map<String,Variant> g, int h);
  public void CloseNotification(UInt32 a);
  public List<String> GetCapabilities();
  public Quad<String, String, String, String> GetServerInformation();

}

