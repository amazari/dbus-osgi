package org.freedesktop.dbus.osgi

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.freedesktop.dbus.DBusConnection
import org.freedesktop.dbus._
import org.freedesktop.DBus
import org.freedesktop.DBus.Introspectable
import org.osgi.framework.ServiceFactory
import java.util.Timer
import java.util.TimerTask
import java.util.Date

class DBusServicesActivator extends BundleActivator {
  
	var conn: DBusConnection = null
	var dbus: DBus = null
  
	def start(context: BundleContext) {
		conn = DBusConnection.getConnection(DBusConnection.SESSION)
		dbus = conn.getRemoteObject("org.freedesktop.DBus", "/org/freedesktop/DBus", classOf[DBus])
		var names = dbus.ListNames.filter(service => {service != "org.freedesktop.DBus" && !service.startsWith(":")})
		
	
		names.foreach(service => {

				  try {
				  var dbusProxyClass = context.getBundle().loadClass(service);
				  val proxy = conn.getRemoteObject(service, "/" + service.replace('.', '/'))
				  
				  context.registerService (service, proxy, null);
				  println ("%s registred".format(service))
			  } catch {
		    case e:ClassNotFoundException => //println ("Proxy for %s can not be found. You might want to generate it using CreateInterface".format (service));
		    case e => println ("Unhandheld exception: %s".format(e))
		  }
		})

	}
  def stop(context: BundleContext) {

  // conn.disconnect
  }
}
