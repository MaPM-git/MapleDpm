package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class OverloadModePlasmaCurrent extends AttackSkill {
    public OverloadModePlasmaCurrent() {
        this.setName("오버로드 모드(플라즈마 전류)");
        this.setAttackCount(6L * 2);
        this.setDamage(390.0);
        this.setDotDuration(70000L);
        this.setInterval(1800L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
