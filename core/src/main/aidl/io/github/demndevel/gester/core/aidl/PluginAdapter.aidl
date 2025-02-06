package io.github.demndevel.gester.core.aidl;

import io.github.demndevel.gester.core.parcelables.ParcelableOperationResult;
import io.github.demndevel.gester.core.parcelables.PluginMetadata;
import io.github.demndevel.gester.core.parcelables.PluginSetting;
import io.github.demndevel.gester.core.parcelables.PluginSummary;
import io.github.demndevel.gester.core.parcelables.ParcelablePluginCommand;
import io.github.demndevel.gester.core.parcelables.ParcelablePluginFallbackCommand;
import android.os.ParcelUuid;

interface PluginAdapter {
    void executeFallbackCommand(in ParcelUuid commandUuid, in String input);

    void executeCommand(in ParcelUuid commandUuid);

    List<ParcelableOperationResult> executeAnyInput(in String input);

    List<ParcelablePluginCommand> getAllCommands();

    List<ParcelablePluginFallbackCommand> getAllFallbackCommands();

    PluginMetadata getPluginMetadata();

    PluginSummary getPluginSummary();

    void setSetting(in ParcelUuid settingUuid, in String newValue);

    List<PluginSetting> getPluginSettings();
}
