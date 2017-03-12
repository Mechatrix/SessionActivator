package testpack;
import java.util.Date;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListenerExample implements NativeKeyListener {
	
	private Date startTime= new Date();;
	
	
	
    public Date getStartTime() {
		return startTime;
	}

    
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        startTime= new Date();
                
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @SuppressWarnings("static-access")
	public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
    }
    
    public static void hook() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
    }

}