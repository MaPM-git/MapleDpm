package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrawlingFear extends AttackSkill {
    public CrawlingFear() {
        this.setName("기어 다니는 공포");
        this.setDamage(400.0 + 893);
        this.setAttackCount(15L);
        this.setDelay(360L);
        //this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
