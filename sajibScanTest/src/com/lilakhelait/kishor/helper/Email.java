package com.lilakhelait.kishor.helper;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Email {

	  public static void email(Context ctx,  String subject, String body)
      {
          try
          {
              // use the builtin chooser for users 'send' app
              Intent sendIntent = new Intent(Intent.ACTION_SEND);
              sendIntent.setType("text/plain");

              sendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String [] {"example@email.com"});
              sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
              sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);

              ctx.startActivity (Intent.createChooser(sendIntent, "Send Email..."));
          }
          catch (Exception e) 
          {
              Toast.makeText (ctx, "No email account is found on this device",Toast.LENGTH_SHORT).show();
          }
      }
}
