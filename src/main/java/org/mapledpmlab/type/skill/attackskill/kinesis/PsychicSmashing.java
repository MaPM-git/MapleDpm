package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kinesis.UltimateMaterialBuff;

public class PsychicSmashing extends AttackSkill {
    public PsychicSmashing() {
        this.setName("싸이킥 스매싱");
        this.setDamage(1034.0);
        this.setDelayByAttackSpeed(600L);
        this.setAttackCount(5L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new UltimateMaterialBuff());
        this.setAddDamage(20L);     // 싸이킥 그랩-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
