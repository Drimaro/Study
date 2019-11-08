import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\konstantin.silin\\Pictures\\724130.jpg";

        Spi.instance.SystemParametersInfo(
                new WinDef.UINT_PTR(Spi.spiSetDeskWallpaper),
                new WinDef.UINT_PTR(0),
                path,
                new WinDef.UINT_PTR(Spi.spifUpdateIniFile | Spi.spifSendWinIniChange));

    }

    private interface Spi extends StdCallLibrary {
        long spiSetDeskWallpaper = 20;
        long spifUpdateIniFile = 0x01;
        long spifSendWinIniChange = 0x02;

        Spi instance = (Spi) Native.load("user32", Spi.class, new HashMap<String, Object>() {{
            put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
            put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
        }});

        boolean SystemParametersInfo(
                WinDef.UINT_PTR uiAction,
                WinDef.UINT_PTR uiParam,
                String pvParam,
                WinDef.UINT_PTR fWinIni
        );
    }
}
