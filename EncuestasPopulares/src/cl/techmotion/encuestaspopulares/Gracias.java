package cl.techmotion.encuestaspopulares;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Gracias extends Activity {

	private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gracias);
        WindowManager.LayoutParams params = getWindow().getAttributes();
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.height = WindowManager.LayoutParams.MATCH_PARENT;
		getWindow().setAttributes(params);
		webView = (WebView)findViewById(R.id.webview);
		WebSettings ws = webView.getSettings();
		// enable javascript
		ws.setJavaScriptEnabled(true);
		// enable database
		ws.setDatabaseEnabled(true);
		ws.setDomStorageEnabled(true);
		ws.setDatabasePath(getDatabasePath("webview").getAbsolutePath());
		// enable cache
		ws.setAppCacheMaxSize(1024*1024*4);
		ws.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
		ws.setAllowFileAccess(true);
		ws.setAppCacheEnabled(true);

		webView.setWebViewClient(new WebViewClient());
		
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
				quotaUpdater.updateQuota(estimatedSize*2);
			}
			@Override
			public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
				quotaUpdater.updateQuota(spaceNeeded*2);
			}
		});
		
webView.loadUrl("http://encuestas.techmotion.cl");
		onNewIntent(getIntent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gracias, menu);
        return true;
    }
    


}
