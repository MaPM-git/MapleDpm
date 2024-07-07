package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimatePsychicBullet extends AttackSkill {
    public UltimatePsychicBullet() {
        this.setName("얼티메이트-싸이킥 불릿");
        this.setDamage(1210.0);
        this.setAttackCount(6L);
        this.setDelay(570L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new UltimatePsychicBulletBlackHole());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
