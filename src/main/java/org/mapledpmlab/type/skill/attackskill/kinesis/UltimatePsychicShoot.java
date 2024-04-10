package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kinesis.UltimateMaterialBuff;

public class UltimatePsychicShoot extends AttackSkill {
    public UltimatePsychicShoot() {
        this.setName("얼티메이트-싸이킥 샷");
        this.setDamage(765.0);
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(4L * 5 * 2);
        this.setRelatedSkill(new UltimateMaterialBuff());
        this.setAddDamage(20L);     // 싸이킥 그랩-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
