package ru.surok.myfirstapplication.Data.DataSources;

import android.content.Context;
import android.content.Intent;

public class ExternalStorageDataSource {

    public void createFile(Context context) {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "invoice.txt");
        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when your app creates the document.
//        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);
        context.startActivity(intent);
    }
}
