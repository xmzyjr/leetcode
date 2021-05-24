package feture.testt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class Test2 {

    /**
     * 标题：用户在线峰值
     * 描述信息
     * 已知一天内用户登录登出的日志（数据量较大），求这一天用户在线的最大峰值和持续时间段
     * 日志包含字段（userid, login_time, logout_time）
     * 登录登出时间精确到秒
     */
    public class Log {

        String userId;

        long loginTime;

        long logoutTime;
    }

    private int time = 86400;

    public class Result {

        long startTime;

        long endTime;
    }

    public List<Result> find(List<Log> logs) {
        int[] oneDay = new int[86400];
        for (int i = 0; i < logs.size(); i++) {
            oneDay[(int) (logs.get(i).loginTime % time)]++;
            oneDay[(int) (logs.get(i).logoutTime % time)]--;
        }
        for (int i = 1; i < oneDay.length; i++) {
            oneDay[i] = oneDay[i] + oneDay[i - 1];
        }
        int max = 0;
        for (int time : oneDay) {
            max = Math.max(max, time);
        }
        List<Result> list = new ArrayList<>();
        Integer startTime = null;
        for (int i = 0; i < oneDay.length; i++) {
            if (oneDay[i] == max && startTime == null) {
                startTime = i;
            } else if (oneDay[i] != max && startTime != null) {
                Result res = new Result();
                res.startTime = startTime;
                res.endTime = i;
                list.add(res);
                startTime = null;
            }
        }
        return list;
    }
}
