package net.craftmayham.movehotbar.mixin.client.gui.hud;

import net.craftmayham.movehotbar.MoveHotbar;
import net.minecraft.client.gui.hud.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = BossBarHud.class, priority = -1)
public class BossBarHudMixin {
    @ModifyArg(method = "renderBossBar*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/BossBarHud;renderBossBar(Lnet/minecraft/client/gui/DrawContext;IILnet/minecraft/entity/boss/BossBar;II)V"), index = 1)
    private int modifyBossBarX(int value) { return value + MoveHotbar.getBossBarX(); }
    @ModifyArg(method = "renderBossBar*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/BossBarHud;renderBossBar(Lnet/minecraft/client/gui/DrawContext;IILnet/minecraft/entity/boss/BossBar;II)V"), index = 2)
    private int modifyBossBarY(int value) { return value + MoveHotbar.getBossBarY(); }
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), index = 2)
    private int modifyBossBarTextX(int value) { return value + MoveHotbar.getBossBarX(); }
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), index = 3)
    private int modifyBossBarTextY(int value) { return value + MoveHotbar.getBossBarY(); }
}
