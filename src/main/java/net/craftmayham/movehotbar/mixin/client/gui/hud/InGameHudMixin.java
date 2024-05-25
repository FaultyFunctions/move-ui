package net.craftmayham.movehotbar.mixin.client.gui.hud;

import net.craftmayham.movehotbar.MoveHotbar;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
@Mixin(value = InGameHud.class, priority = -1)
public class InGameHudMixin {
    @ModifyArg(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 1)
    private int modifyHotbarX(int value) {
        return value + MoveHotbar.getHotbarX();
    }
    @ModifyArg(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyHotbarY(int value) {
        return value - MoveHotbar.getHotbarY();
    }
    @ModifyArg(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(Lnet/minecraft/client/gui/DrawContext;IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;I)V"), index = 1)
    private int modifyItemX(int value) {
        return value + MoveHotbar.getHotbarX();
    }
    @ModifyArg(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(Lnet/minecraft/client/gui/DrawContext;IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;I)V"), index = 2)
    private int modifyItemY(int value) {
        return value - MoveHotbar.getHotbarY();
    }
    @ModifyVariable(method = "renderHeldItemTooltip", at = @At(value = "STORE"), ordinal = 1)
    private int modifyHeldItemTooltipX(int value) {
        return value + MoveHotbar.getTextX();
    }
    @ModifyVariable(method = "renderHeldItemTooltip", at = @At(value = "STORE"), ordinal = 2)
    private int modifyHeldItemTooltipY(int value) {
        return value - MoveHotbar.getTextY();
    }
    @ModifyArg(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 1)
    private int modifyExperienceBarX(int value) {
        return value + MoveHotbar.getExpX();
    }
    @ModifyArg(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyExperienceBarY(int value) {
        return value - MoveHotbar.getExpY();
    }
    @ModifyArg(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawText(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;IIIZ)I"), index = 2)
    private int modifyXpDX(int value) {
        return value + MoveHotbar.getExpDX();
    }
    @ModifyArg(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawText(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;IIIZ)I"), index = 3)
    private int modifyXpDY(int value) {
        return value - MoveHotbar.getExpDY();
    }
    @ModifyArg(method = "renderMountJumpBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 1)
    private int modifyJumpX(int value) {
        return value + MoveHotbar.getExpX();
    }
    @ModifyArg(method = "renderMountJumpBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyJumpY(int value) {
        return value - MoveHotbar.getExpY();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"), index = 2)
    private int modifyHealthBarX(int value) {
        return value + MoveHotbar.getHealthX();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"), index = 3)
    private int modifyHealthBarY(int value) {
        return value - MoveHotbar.getHealthY();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"), index = 4)
    private int modifyHealthSpacing(int value) {
        return value + MoveHotbar.getHealthSpacing();
    }
    @ModifyArg(method = "renderMountHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 1)
    private int modifyMountHealthX(int value) {
        return value + MoveHotbar.getHungerX();
    }
    @ModifyArg(method = "renderMountHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyMountHealthY(int value) {
        return value - MoveHotbar.getHungerY();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 1)
    private int modifyStatusBarsX(int value) {
        return value + MoveHotbar.getHungerX();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyStatusBarsY(int value) {
        return value - MoveHotbar.getHungerY();
    }
    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyStatusBarsSpacing(int value) {
        return value + MoveHotbar.getHungerSpacing();
    }
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), slice = @Slice(from = @At("HEAD"), to = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I")), index = 2)
    private int modifyActionBarX(int value) { return value + MoveHotbar.getActionBarX(); }
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), slice = @Slice(from = @At("HEAD"), to = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I")), index = 3)
    private int modifyActionBarY(int value) { return value + MoveHotbar.getActionBarY(); }
}
