package org.valkyrienskies.eureka.gui.engine

import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
import net.minecraft.world.entity.player.Inventory
import org.valkyrienskies.eureka.EurekaMod

class EngineScreen(handler: EngineScreenMenu, playerInventory: Inventory, text: Component) :
    AbstractContainerScreen<EngineScreenMenu>(handler, playerInventory, text) {

    override fun renderBg(guiGraphics: GuiGraphics, partialTicks: Float, mouseX: Int, mouseY: Int) {
        val xP = (width - imageWidth) / 2
        val yP = (height - imageHeight) / 2
        // 1.21.11: RenderSystem.setShader was removed and GuiGraphics.pose() is now a 2D
        // Matrix3x2fStack (no pushPose/3-arg scale). The engine screen's scaled-texture
        // compositing (coal animation + heat states) is reduced to a single background blit
        // until the render layer is ported in the runtime phase.
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, xP, yP, 0f, 0f, imageWidth, imageHeight, 512, 512)
    }

    override fun renderLabels(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int) {
        // super.renderLabels(poseStack, mouseX, mouseY)
    }

    companion object { // TEXTURE DATA
        internal val TEXTURE = Identifier.fromNamespaceAndPath(EurekaMod.MOD_ID, "textures/gui/engine.png")

        private const val FIRE_HOLE_X = 10 / 2
        private const val FIRE_HOLE_Y = 8 / 2

        private const val FIRE_HOLE_WIDTH = 156 / 2
        private const val FIRE_HOLE_HEIGHT = 68 / 2

        private const val HEATED_GLASS_X = 10 / 2
        private const val HEATED_GLASS_Y = 172 / 2
        private const val GLASS_X = 10 / 2
        private const val GLASS_Y = 244 / 2

        private const val HEATED_CONTAINER_X = 10 / 2
        private const val HEATED_CONTAINER_Y = 390 / 2
        private const val CONTAINER_X = 10 / 2
        private const val CONTAINER_Y = 318 / 2

        // TODO fill in actual pixel coords
        private const val COAL_4_X = 184 / 2
        private const val COAL_4_Y = 18 / 2
        private const val COAL_3_X = 184 / 2
        private const val COAL_3_Y = 80 / 2
        private const val COAL_2_X = 184 / 2
        private const val COAL_2_Y = 128 / 2
        private const val COAL_1_X = 184 / 2
        private const val COAL_1_Y = 166 / 2
        private const val COAL_WIDTH = 158 / 2
        private const val COAL_4_HEIGHT = 60 / 2
        private const val COAL_3_HEIGHT = 44 / 2
        private const val COAL_2_HEIGHT = 34 / 2
        private const val COAL_1_HEIGHT = 26 / 2

        private const val COAL_MULTI_MAX = COAL_1_HEIGHT.toFloat()
        private const val COAL_4_MULT = COAL_4_HEIGHT.toFloat() / COAL_MULTI_MAX
        private const val COAL_3_MULT = COAL_3_HEIGHT.toFloat() / COAL_MULTI_MAX
        private const val COAL_2_MULT = COAL_2_HEIGHT.toFloat() / COAL_MULTI_MAX
        private const val COAL_1_MULT = 1f
    }
}
