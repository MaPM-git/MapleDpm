package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Snipe extends AttackSkill {
    public Snipe() {
        this.setName("스나이핑");
        this.setAttackCount(11L);       // 어디셔널 볼트, 스나이핑-보너스 어택
        this.setDamage(670.0 + 90);
        this.setDelayByAttackSpeed(780L);
        this.addIgnoreDefenseList(40L);
        this.addCriticalP(100.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10 + 20L);    // 스나이핑-리인포스, 보스 킬러
        this.setApplyFinalAttack(true);
    }
}
