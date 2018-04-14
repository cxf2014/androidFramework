package cn.xyb100.zzqg.logger;

public interface FormatStrategy {

  void log(int priority, String tag, String message);
}
