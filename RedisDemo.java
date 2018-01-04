import redis.clients.jedis.Jedis;

/*
*  测试redis每秒读取数
* */
public class RedisDemo {
    public static void main(String[] args) {
        //1.连接redis
        Jedis jedis = new Jedis("localhost",6379);
        //if need password:
        jedis.auth("yws");

        int i = 0; //记录操作记录数
        try{
            long start = System.currentTimeMillis();
            while (true){
                long end = System.currentTimeMillis();
                if (end - start >= 1000){ //大于1秒则结束操作
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }

        }finally {
            jedis.close();
        }

        System.out.println("redis每秒操作：" + i + "次");
    }

}
