package org.freedesktop.dbus.osgi.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.freedesktop.Notifications;
import org.freedesktop.Quad;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private ServiceTracker simpleLogServiceTracker;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		ServiceReference<Notifications> reference = context
				.getServiceReference(Notifications.class);
		Notifications service = context.getService(reference);

		// Quad<String, String, String, String> serverinformation =
		// service.GetServerInformation();
		// System.out.println(serverinformation);
		List<String> actions = new ArrayList<String>();
		Map<String, Variant> hints = new HashMap<String, Variant>();
		int timeout = 10 * 1000;
		service.Notify("OSGi-DBus test", new UInt32(42), "", "Baby", "Doll",
				actions, hints, 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {

	}

}
