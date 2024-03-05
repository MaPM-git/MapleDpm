package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonCuttingScimitar extends AttackSkill {
    public SummonCuttingScimitar() {
        this.setName("서먼 커팅 시미터");
        this.setDamage(125.0 + 80 + 100 + 177);
        this.setAttackCount(5L);
        this.setDelay(150L);
        //this.setDelayByAttackSpeed(780L);
        this.setCooldown(4.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setApplyReuse(true);
    }
}
