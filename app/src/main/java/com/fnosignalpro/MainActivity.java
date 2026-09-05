package com.fnosignalpro;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout content;
    private final int BG = Color.rgb(11, 16, 32);
    private final int CARD = Color.rgb(21, 28, 48);
    private final int TEXT = Color.rgb(240, 244, 255);
    private final int MUTED = Color.rgb(170, 180, 205);
    private final int GREEN = Color.rgb(70, 210, 130);
    private final int RED = Color.rgb(240, 90, 100);

    private TextView text(String s, float size, boolean bold) {
        TextView v = new TextView(this);
        v.setText(s);
        v.setTextColor(TEXT);
        v.setTextSize(size);
        v.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL);
        v.setPadding(16, 10, 16, 10);
        return v;
    }

    private LinearLayout panel() {
        LinearLayout p = new LinearLayout(this);
        p.setOrientation(LinearLayout.VERTICAL);
        p.setPadding(12, 8, 12, 8);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(24);
        p.setBackground(bg);
        return p;
    }

    private void addPanel(String title, String body, String risk) {
        LinearLayout p = panel();
        p.addView(text(title, 18, true));
        p.addView(text(body, 14, false));
        TextView r = text("Risk: " + risk, 13, true);
        p.addView(r);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 14);
        content.addView(p, lp);
    }

    private void showTab(String tab) {
        content.removeAllViews();

        if ("Home".equals(tab)) {
            content.addView(text("MARKET LIVE  •  INDIAN F&O", 13, true));
            TextView n = text("NIFTY 50   24,975.40   +0.55%", 19, true);
            n.setTextColor(GREEN);
            content.addView(n);
            TextView b = text("BANK NIFTY   52,262.30   +0.73%", 19, true);
            b.setTextColor(GREEN);
            content.addView(b);
            content.addView(text("Latest Signals", 24, true));

            addPanel(
                "BUY  NIFTY 25,000 CE",
                "Entry ₹125–130  •  T1 ₹145  •  T2 ₹160  •  SL ₹110",
                "MEDIUM");

            addPanel(
                "BUY  BANK NIFTY 51,500 PE",
                "Entry ₹145–150  •  T1 ₹175  •  T2 ₹195  •  SL ₹125",
                "LOW");

            addPanel(
                "BUY  NIFTY 24,900 CE",
                "Entry ₹110–115  •  T1 ₹145  •  T2 ₹165  •  SL ₹90",
                "HIGH");

            TextView note = text(
                "Demo data only. These signals are simulated and do not execute trades.",
                12, false);
            note.setTextColor(MUTED);
            content.addView(note);

        } else if ("Market".equals(tab)) {
            content.addView(text("Market", 26, true));
            content.addView(text(
                "NIFTY 50\n24,975.40   +0.55%\n\n" +
                "BANK NIFTY\n52,262.30   +0.73%\n\n" +
                "FINNIFTY\n22,562.30   -0.20%\n\n" +
                "INDIA VIX\n14.82   +1.42%",
                18, false));

        } else if ("Alerts".equals(tab)) {
            content.addView(text("Notifications", 26, true));
            content.addView(text(
                "09:42  BUY NIFTY 25,000 CE\n" +
                "Entry ₹125–130 • Risk MEDIUM\n\n" +
                "09:18  BUY BANK NIFTY 51,500 PE\n" +
                "Entry ₹145–150 • Risk LOW",
                17, false));

        } else {
            content.addView(text("Profile", 26, true));
            content.addView(text(
                "Mobile number login\n" +
                "One active device\n\n" +
                "Subscription Plans\n" +
                "₹99  •  5 notifications/day\n" +
                "₹299 •  20 notifications/day\n" +
                "₹399 •  Unlimited notifications\n\n" +
                "Risk preference\nLOW  •  MEDIUM  •  HIGH",
                17, false));
        }
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BG);

        LinearLayout header = new LinearLayout(this);
        header.setGravity(Gravity.CENTER_VERTICAL);

        TextView title = text("TradeGuide", 25, true);
        header.addView(title, new LinearLayout.LayoutParams(0, 70, 1));

        Button bell = new Button(this);
        bell.setText("🔔");
        bell.setContentDescription("Notifications");
        header.addView(bell, new LinearLayout.LayoutParams(75, 70));
        root.addView(header);

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(18, 8, 18, 20);
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        String[] tabs = {"Home", "Market", "Alerts", "Profile"};

        for (String tab : tabs) {
            Button button = new Button(this);
            button.setText(tab);
            button.setOnClickListener(v -> showTab(tab));
            nav.addView(button, new LinearLayout.LayoutParams(0, 64, 1));
        }
        root.addView(nav);

        setContentView(root);
        showTab("Home");
    }
}
