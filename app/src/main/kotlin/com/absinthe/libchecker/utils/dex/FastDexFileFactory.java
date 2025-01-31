package com.absinthe.libchecker.utils.dex;

import org.jf.dexlib2.DexFileFactory;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.MultiDexContainer;

import java.io.File;
import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FastDexFileFactory {
  public static MultiDexContainer<? extends DexBackedDexFile> loadDexContainer(
    @Nonnull File file, @Nullable final Opcodes opcodes) throws IOException {
    if (!file.exists()) {
      throw new DexFileFactory.DexFileNotFoundException("%s does not exist", file.getName());
    }

    return new ZipDexContainer2(file, opcodes);
  }
}
