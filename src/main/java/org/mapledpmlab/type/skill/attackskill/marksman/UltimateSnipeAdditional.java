package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateSnipeAdditional extends AttackSkill {
    public UltimateSnipeAdditional() {
        this.setName("얼티밋 스나이핑(추가타)");
        this.setAttackCount(7L);        // 어디셔널 볼트, 스나이핑-보너스 어택
        this.setDamage(410.0 + 60);
        this.addIgnoreDefenseList(40L);
        this.addCriticalP(100.0);
        this.setDotDuration(180L);
        this.setLimitAttackCount(2L);
        this.setInterval(90L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10 + 20L);    // 스나이핑-리인포스, 보스 킬러
    }
}
