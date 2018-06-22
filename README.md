# YCAmountView
- 购物车数量加减自定义控件
- 失效效果如下所示：
<image src="https://github.com/yangchong211/YCAmountView/blob/master/image/amount1.jpg" width=300/>



#### 1.需求说明
- 可以限制购物车最小值和最大值
- 当处于最小值的时候，设置不可点击；当处于最大值的时候，设置不可点击
- 最小值或者最大值图片是灰色的，处于最大值和最小值之间是深色的
- 可以设置控件监听listener方法，监听购物车数量是否发生了变化等等
- 购物车数量可以直接输入，也可以设置不可点击


#### 2.使用说明

```
AmountView avView = findViewById(R.id.av_view);
//avView.setAmountNum(10);
avView.setAmountNum(2,10,1);
//设置是否可以点击
avView.setEtClickable(false);
int amount = avView.getAmount();
avView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
    @Override
    public void onAmountChange(boolean isChange, boolean isMaxOrMin, int amount) {
        Log.e("change",isChange+"-------"+isMaxOrMin+"----------"+amount);
    }
});
```

#### 3.其他说明
- gitHub：https://github.com/yangchong211
- 喜马拉雅听书：http://www.ximalaya.com/zhubo/71989305/
- 知乎：https://www.zhihu.com/people/yang-chong-69-24/pins/posts
- 简书：http://www.jianshu.com/u/b7b2c6ed9284
- csdn：http://my.csdn.net/m0_37700275

