# hotfix
动态补丁：使用ClassLoader加载dex中的类，使用反射调用类中方法。

#### moudle说明：
fix moudle为补丁的包装
pro moudle为程序的主要代码


将pro打成apk放在fix的assets目录下，重命名为momo。通过app中调用fix的Main方法就可以了，成功的结果为，打印log 10。

