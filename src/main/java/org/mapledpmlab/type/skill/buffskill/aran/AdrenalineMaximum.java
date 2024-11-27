package org.mapledpmlab.type.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdrenalineMaximum extends BuffSkill {
    public AdrenalineMaximum() {
        this.setName("아드레날린 맥시멈");
        this.setDuration(5L + 5);       // 부스트 엔드-아드레날린 서지
        this.setCooldown(180.0);
        this.setDelay(30L);
    }
}
