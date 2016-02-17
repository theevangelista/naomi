# Naomi

A Slack bot notification for exceptions

Naomi provides a way to notify your team when a uncaught exception occurs, sending a message into Slack channel.


Usage
---

Create a Naomi instance, you can use it as singleton if desired.

```java

BotProperties properties = new SimpleBotProperties("https://hooks.slack.com/services/YOUR/SLACK/SERVICE_URL");
Hook hookClient = new DefaultHookClient(properties);
Naomi naomi = new Naomi(hookClient);

```

Then on your uncaught handler or anywhere you want to send the exception

```java

naomi.notify(exception);

```

Or with an additional message

```
naomi.notify(exception,"Execution of method XXX halted ");
```
