package voodoo.data.curse

import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor

// TODO: inline
@Serializable(with = ProjectID.Companion::class)
data class ProjectID(val value: Int) {
    override fun toString(): String {
        return value.toString()
    }

    val valid: Boolean
        get() = value > 0

    @Serializer(forClass = ProjectID::class)
    companion object {
        override val descriptor = PrimitiveSerialDescriptor("ProjectID", PrimitiveKind.INT)

        override fun deserialize(decoder: Decoder): ProjectID {
            return ProjectID(decoder.decodeInt())
        }

        override fun serialize(encoder: Encoder, obj: ProjectID) {
            encoder.encodeInt(obj.value)
        }

        val INVALID = ProjectID(-1)
    }
}