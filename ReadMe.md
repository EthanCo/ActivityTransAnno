# ActivityTransAnno #
编译时注解，实现Activity 过渡 Transition，不使用运行时注解，主体上不使用反射，不影响性能。

## 使用 ##
### Injector ###
在需要使用Activity Transition的Activity的onCreate中添加

	TransInjector.inject(this);
	
### 添加注解 ###

	@ActivityTransition(Transition.Explode)
	public class SecondActivity extends AppCompatActivity {
	    @Override
	    protected void onCreate(@Nullable Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	
	        TransInjector.inject(this);
	        setContentView(R.layout.activity_second);
	    }
	}

### 其他Activity中启动 ###

	intent = new Intent(this, SecondActivity.class);
    ActivityCompat.startActivity(this, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());


## 注解说明 ##
###@ActivityTransition
Activity Transition 注解，Enter和Exit的动画一致  

## Transition说明 ##
现阶段支持Explode，Fade，Slide

### 使用 ###
	
	@ActivityTransition(Transition.Fade)

	
	