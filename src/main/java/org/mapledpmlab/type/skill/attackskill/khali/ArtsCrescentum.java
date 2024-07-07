package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtsCrescentum extends AttackSkill implements ArtsSkill {
    public ArtsCrescentum() {
        this.setName("아츠 : 크레센텀");
        this.setDamage(975.0);
        this.setAttackCount(4L + 1);
        this.setCooldown(5.0);
        //this.setDelay(150L);
        this.setDelayByAttackSpeed(630L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);     // 아츠-리인포스
        this.setApplyReuse(true);
    }
}
