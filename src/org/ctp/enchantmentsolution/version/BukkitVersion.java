package org.ctp.enchantmentsolution.version;

import org.bukkit.Bukkit;
import org.ctp.enchantmentsolution.utils.ChatUtils;

public class BukkitVersion {

	private String version = getBukkitVersion();
	private String apiVersion = getBukkitApiVersion();
	private boolean versionAllowed = allowedBukkitVersion();
	private int versionNumber;

	private String getBukkitVersion() {
		String a = Bukkit.getVersion();
		String version = a.substring(a.lastIndexOf(':') + 1, a.lastIndexOf(')')).trim();

		return version;
	}

	private String getBukkitApiVersion() {
		String a = Bukkit.getServer().getClass().getPackage().getName();
		String apiVersion = a.substring(a.lastIndexOf('.') + 1).trim();

		return apiVersion;
	}

	private boolean allowedBukkitVersion() {
		versionNumber = 0;

		// BukkitVersion
		ChatUtils.sendInfo("Checking Bukkit Version: " + version);

		// Check
		switch (version) {
			case "1.13":
				versionNumber = 1;
				break;
			case "1.13.1":
				versionNumber = 2;
				break;
			case "1.13.2":
				versionNumber = 3;
				break;
			case "1.14":
				versionNumber = 4;
				break;
			case "1.14.1":
				versionNumber = 5;
				break;
			case "1.14.2":
				versionNumber = 6;
				break;
			case "1.14.3":
				versionNumber = 7;
				break;
			case "1.14.4":
				versionNumber = 8;
				break;
			case "1.15":
				versionNumber = 9;
				break;
			case "1.15.1":
				versionNumber = 10;
				break;
			case "1.15.2":
				versionNumber = 11;
				break;
			case "1.16.1":
				versionNumber = 12;
				break;
			case "1.16.2":
				versionNumber = 13;
				break;
			case "1.16.3":
				versionNumber = 14;
				break;
			case "1.16.4":
				versionNumber = 15;
				break;
		}
		if (versionNumber > 0) {
			ChatUtils.sendInfo("Found version " + version + ". Setting version number to " + versionNumber + ".");
			return true;
		}

		// BukkitApiVersion
		ChatUtils.sendWarning("Could not find version " + version + ".");
		ChatUtils.sendInfo("Checking Bukkit API Version: " + apiVersion);

		// Check
		switch (apiVersion) {
			case "v1_13_R1":
				versionNumber = 1;
				break;
			case "v1_13_R2":
				versionNumber = 3;
				break;
			case "v1_14_R1":
				versionNumber = 8;
				break;
			case "v1_15_R1":
				versionNumber = 11;
				break;
			case "v1_16_R1":
				versionNumber = 12;
				break;
			case "v1_16_R2":
				versionNumber = 14;
				break;
			case "v1_16_R3":
				versionNumber = 15;
				break;
		}
		if (versionNumber > 0) {
			ChatUtils.sendInfo("Found version " + apiVersion + ". Setting version number to " + versionNumber + ".");
			return true;
		}
		ChatUtils.sendSevere("This version is not defined! Features that require NMS have been disabled, and issues may arise with certain features. " + "Please wait for an update for this version.");
		return false;
	}

	public boolean isVersionAllowed() {
		return versionAllowed;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public String getVersion() {
		return version;
	}

	public String getAPIVersion() {
		return apiVersion;
	}
}
