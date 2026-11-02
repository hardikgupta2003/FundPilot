package com.hardik.fundpilot.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Primary Emerald Palette
val EmeraldPrimary = Color(0xFF006446)
val EmeraldPrimaryContainer = Color(0xFF087F5B)
val EmeraldOnPrimary = Color(0xFFFFFFFF)
val EmeraldOnPrimaryContainer = Color(0xFFCFFFE5)

val EmeraldSecondary = Color(0xFF006C4C)
val EmeraldSecondaryContainer = Color(0xFF79F6C2)
val EmeraldOnSecondary = Color(0xFFFFFFFF)
val EmeraldOnSecondaryContainer = Color(0xFF007150)

val EmeraldTertiary = Color(0xFF006446)
val EmeraldTertiaryContainer = Color(0xFF007F5B)
val EmeraldOnTertiary = Color(0xFFFFFFFF)
val EmeraldOnTertiaryContainer = Color(0xFFCDFFE5)

// Light Mode Surfaces & Off-Whites
val LightBackground = Color(0xFFF4FBF6)
val LightOnBackground = Color(0xFF161D1A)
val LightSurface = Color(0xFFF4FBF6)
val LightSurfaceDim = Color(0xFFD5DCD7)
val LightSurfaceBright = Color(0xFFF4FBF6)
val LightSurfaceContainerLowest = Color(0xFFFFFFFF)
val LightSurfaceContainerLow = Color(0xFFEFF5F0)
val LightSurfaceContainer = Color(0xFFE9EFEA)
val LightSurfaceContainerHigh = Color(0xFFE3EAE5)
val LightSurfaceContainerHighest = Color(0xFFDDE4DF)
val LightOnSurface = Color(0xFF161D1A)
val LightOnSurfaceVariant = Color(0xFF3E4943)
val LightOutline = Color(0xFF6E7A73)
val LightOutlineVariant = Color(0xFFBDC9C1)

// Dark Mode Surfaces
val DarkBackground = Color(0xFF121417)
val DarkOnBackground = Color(0xFFECF2ED)
val DarkSurface = Color(0xFF121417)
val DarkSurfaceDim = Color(0xFF0E1012)
val DarkSurfaceBright = Color(0xFF343A37)
val DarkSurfaceContainerLowest = Color(0xFF0D0F11)
val DarkSurfaceContainerLow = Color(0xFF16191D)
val DarkSurfaceContainer = Color(0xFF1A1D21)
val DarkSurfaceContainerHigh = Color(0xFF23272C)
val DarkSurfaceContainerHighest = Color(0xFF2B322F)
val DarkOnSurface = Color(0xFFECF2ED)
val DarkOnSurfaceVariant = Color(0xFFBDC9C1)
val DarkOutline = Color(0xFF88938C)
val DarkOutlineVariant = Color(0xFF3E4943)

// Dark Mode Primary & Accent Shifts
val EmeraldPrimaryDark = Color(0xFF78D9AF)
val EmeraldPrimaryContainerDark = Color(0xFF005139)
val EmeraldOnPrimaryDark = Color(0xFF003827)
val EmeraldOnPrimaryContainerDark = Color(0xFF94F6CA)

// Financial Gain & Loss Returns Status Colors
val GainPositive = Color(0xFF087F5B)
val GainPositiveContainer = Color(0xFFE6F4EA)
val OnGainPositiveContainer = Color(0xFF034D35)

val GainPositiveDark = Color(0xFF20C997)
val GainPositiveContainerDark = Color(0xFF003827)
val OnGainPositiveContainerDark = Color(0xFF78D9AF)

val LossNegative = Color(0xFFFA5252)
val LossNegativeContainer = Color(0xFFFFE3E3)
val OnLossNegativeContainer = Color(0xFF93000A)

val LossNegativeDark = Color(0xFFFF6B6B)
val LossNegativeContainerDark = Color(0xFF4A0007)
val OnLossNegativeContainerDark = Color(0xFFFFDAD6)

// Custom Financial Status Extended Palette
@Immutable
data class ExtendedFinancialColors(
    val gainPositive: Color,
    val gainPositiveContainer: Color,
    val onGainPositiveContainer: Color,
    val lossNegative: Color,
    val lossNegativeContainer: Color,
    val onLossNegativeContainer: Color
)

val LocalExtendedFinancialColors = staticCompositionLocalOf {
    ExtendedFinancialColors(
        gainPositive = GainPositive,
        gainPositiveContainer = GainPositiveContainer,
        onGainPositiveContainer = OnGainPositiveContainer,
        lossNegative = LossNegative,
        lossNegativeContainer = LossNegativeContainer,
        onLossNegativeContainer = OnLossNegativeContainer
    )
}
