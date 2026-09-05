# TradeGuide Android App

A GitHub Actions-ready Android demo application for the TradeGuide concept.

## Included
- Market dashboard
- NIFTY 50 and BANK NIFTY cards
- BUY CALL / BUY PUT style signal cards
- Entry, targets and stop-loss display
- LOW / MEDIUM / HIGH risk labels
- Alerts screen
- Profile and subscription plan display
- Android API 23+ support
- Cloud APK build through GitHub Actions
- No Android Studio required

## Build APK
1. Upload the extracted contents of this project to a new GitHub repository.
2. Commit everything to `main`.
3. Open **Actions**.
4. Select **Build Android APK**.
5. Open the successful run.
6. Under **Artifacts**, download **TradeGuide-APK**.
7. Extract it and install `app-release.apk` on an Android phone.

## Important
The current application uses simulated market/signal data. Live NSE/BSE/derivatives data, licensed news feeds, OTP/SMS verification, subscriptions/payments, push notifications, user profiles, authentication, and production risk/signal logic still need to be connected before real-world use.

Do not use the simulated signals for actual trading.
