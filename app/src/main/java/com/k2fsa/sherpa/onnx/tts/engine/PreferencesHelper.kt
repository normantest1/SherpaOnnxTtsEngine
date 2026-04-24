import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val PREFS_NAME = "com.k2fsa.sherpa.onnx.tts.engine"
    private val SPEED_KEY = "speed"
    private val SID_KEY = "speaker_id"
    private val MODEL_NAME_KEY = "model_name"
    private val MODEL_TYPE_KEY = "model_type" // vits, matcha, etc.

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setModelConfig(name: String, type: String) {
        sharedPreferences.edit()
            .putString(MODEL_NAME_KEY, name)
            .putString(MODEL_TYPE_KEY, type)
            .apply()
    }

    fun getModelName(): String {
        return sharedPreferences.getString(MODEL_NAME_KEY, "paimeng") ?: "paimeng"
    }

    fun getModelType(): String {
        return sharedPreferences.getString(MODEL_TYPE_KEY, "vits") ?: "vits"
    }

    fun setSpeed(value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(SPEED_KEY, value)
        editor.apply()
    }

    fun getSpeed(): Float {
        return sharedPreferences.getFloat(SPEED_KEY, 1.0f)
    }

    fun setSid(value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(SID_KEY, value)
        editor.apply()
    }

    fun getSid(): Int {
        return sharedPreferences.getInt(SID_KEY, 0)
    }
}