## Purpose
If you don't use Jetpack ViewModel for component, you should transfer the instance to Composable function as Parameter.as
Or you can build provider with ProvidableCompositionLocal. Once you select ProvidableCompositionLocal, it comes some boiler-plate code.ProvidableCompositionLocal.ProvidableCompositionLocal.
This project is how to write less code with KSP.

## Setting
```kotlin
class MainActivity : ComponentActivity() {
    @ProvidedComposeLocal val viewModel: MainViewModel = MainViewModel()
    @ProvidedComposeLocal val viewModel2: MainViewModel2 = MainViewModel2()
}
```

## Generated Output
```kotlin
// generated MainActivity_viewModel2.kt
private val LocalMainViewModel2: ProvidableCompositionLocal<MainViewModel2> =
    compositionLocalOf<MainViewModel2> { error("LocalMainViewModel2 isn't provided") }

internal fun viewModel2ProviderValue(viewModel2: MainViewModel2) =
    LocalMainViewModel2 provides viewModel2

@Composable
internal fun viewModel2() = LocalMainViewModel2.current
```
```kotlin
// generated MainActivity_CompositionLocalProvider.kt
@Composable
internal fun MainActivityComposeLocalProvider(content: @Composable () -> Unit): Unit {
    val owner = LocalLifecycleOwner.current as com.example.composelearn.MainActivity
    CompositionLocalProvider(
        viewModelProviderValue(owner.viewModel),
        viewModel2ProviderValue(owner.viewModel2),
        content = content
    )
}
```

## How to use
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            MainActivityComposeLocalProvider {
                // it refers to MainActivity_viewModel2.viewModel2()
                Text(text = "Hello ${viewModel2().name}!")
            }
        }
    }
}
```
