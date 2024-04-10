package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kinesis.UltimateMaterialBuff;

public class UltimateMaterial extends AttackSkill {
    public UltimateMaterial() {
        this.setName("얼티메이트-메테리얼");
        this.setDamage(1295.0 + 130 + 140 + 313);
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(10L);
        this.setRelatedSkill(new UltimateMaterialBuff());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
