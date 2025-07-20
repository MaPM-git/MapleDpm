package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class NightWalker extends Job {

    public NightWalker() {
        // 기본
        super();
        this.setName("나이트워커(0초, 리레단일)");
        this.setConstant(1.75);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2528400.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (172 + 106 + 72 + 195));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (172 + 106 + 72 + 195));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        passive.addAtt(3L);
        passive.addMagic(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("엘리멘탈 엑스퍼트");
        passive.addAttP(10L);
        passive.addMagicP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("엘리멘탈 하모니");
        passive.addMainStat(
                (this.getLevel() - 1) / 2
        );
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("스로잉 마스터리");
        passive.addDamage(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스로잉 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크리티컬 스로우");
        passive.addCriticalP(35.0);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("쉐도우 모멘텀");
        passive.addFinalDamage(1.15);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스피릿 스로잉");
        passive.addAtt(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("플레임 표창");
        passive.addAtt(29L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("아드레날린");
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("스로잉 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(11.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("다크니스 블레싱");
        passive.addAtt(31L);
        passive.addIgnoreDefenseList(16L);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-36L);
        this.addMainStat(4L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("다크니스 어뎁팅");
        doping.addIgnoreDefenseList(35L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("사이펀 바이탈리티-리인포스");
        doping.addAtt(60L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("스로잉 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("다크니스 블레싱(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
