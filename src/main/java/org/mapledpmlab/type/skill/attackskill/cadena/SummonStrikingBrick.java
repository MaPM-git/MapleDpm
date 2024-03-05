package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonStrikingBrick extends AttackSkill {
    public SummonStrikingBrick() {
        this.setName("서먼 스트라이킹 브릭");
        this.setDamage(543.0);
        this.setAttackCount(7L);
        this.setDelay(150L);
        //this.setDelayByAttackSpeed(960L);
        this.setCooldown(8.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setApplyReuse(true);
    }
}
