package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonScratchingClaw extends AttackSkill {
    public SummonScratchingClaw() {
        this.setName("서먼 스크래칭 클로");
        this.setDamage(235.0 + 100 + 177);
        this.setAttackCount(4L);
        this.setDelay(150L + 30);
        this.setCooldown(3.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setApplyReuse(true);
    }
}
