package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberationOrbPassive extends AttackSkill {
    public LiberationOrbPassive() {
        this.setName("리버레이션 오브(패시브)");
        this.setDamage(825.0);
        this.setAttackCount(4L);
        this.setCooldown(6.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
