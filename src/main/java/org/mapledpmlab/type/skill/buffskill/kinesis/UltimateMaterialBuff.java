package org.mapledpmlab.type.skill.buffskill.kinesis;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UltimateMaterialBuff extends BuffSkill {
    public UltimateMaterialBuff() {
        this.setName("얼티메이트-메테리얼");
        this.setDuration(30L);
        this.addBuffIgnoreDefense(15L);
    }
}
