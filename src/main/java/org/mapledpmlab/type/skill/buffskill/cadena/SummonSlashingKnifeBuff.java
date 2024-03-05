package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SummonSlashingKnifeBuff extends BuffSkill {
    public SummonSlashingKnifeBuff() {
        this.setName("서먼 슬래싱 나이프");
        this.setDuration(30L);
        this.addBuffIgnoreDefense(30L);
    }
}
