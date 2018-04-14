package cn.xyb100.zzqg.logger;

public interface LogStrategy {

  void log(int priority, String tag, String message);
}
