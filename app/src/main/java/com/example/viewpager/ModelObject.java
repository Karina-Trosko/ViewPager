package com.example.viewpager;

public enum ModelObject {
    CAMERA_P(R.string.camera_p, R.layout.view_camera_p, R.id.camera_a),
    AUDIO_P(R.string.audio_p, R.layout.view_audio_p, R.id.audio_a),
    PHONE_P(R.string.phone_p, R.layout.view_phone_p, R.id.phone_a),
    SMS_P(R.string.sms_p, R.layout.view_sms_p, R.id.sms_a),
    CALENDAR_P(R.string.calendar_p, R.layout.view_calendar_p, R.id.calendar_a),
    CONTACTS_P(R.string.contacts_p, R.layout.view_contacts_p, R.id.contacts_a),
    LOCATION_P(R.string.location_p, R.layout.view_location_p, R.id.location_a),
    SENSORS_P(R.string.sensors_p, R.layout.view_sensors_p, R.id.sensors_a),
    STORAGE_P(R.string.storage_p, R.layout.view_storage_p, R.id.storage_a);

    private int mTitleResId;
    private int mLayoutResId;
    private int mLayoutButtonId;

    ModelObject(int titleResId, int layoutResId, int layoutButtonId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
mLayoutButtonId  = layoutButtonId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

    public int getLayoutButtonId() {
        return mLayoutButtonId;
    }
}
